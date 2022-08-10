package com.toocol.plugin.tooltip.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhaoZhe (joezane.cn@gmail.com)
 * @date 2022/8/8 20:58
 */
public interface IEscapeMode {
    List<Object> params = new ArrayList<>();

    String desc();

    default String generateTooltip() {
        var desc = desc();
        var idxs = new ArrayList<Integer>();
        for (int i = 0; i < desc.length(); i++) {
            if (desc.charAt(i) == '#') {
                idxs.add(i);
            }
        }
        if (idxs.size() == params.size()) {
            for (int i = 0; i < idxs.size(); i++) {
                desc = desc.replaceFirst("#", getParam(i).toString());
            }
        }
        params.clear();
        return desc;
    }

    default IEscapeMode addParam(Object param) {
        if (param == null) {
            return this;
        }
        params.add(param);
        return this;
    }

    default Object getParam(int idx) {
        return params.get(idx);
    }
}
