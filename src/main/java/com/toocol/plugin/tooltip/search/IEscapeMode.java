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

    default String tooltip() {
        var desc = desc();
        var idxs = new ArrayList<Integer>();
        for (int i = 0; i < desc.length(); i++) {
            if (desc.charAt(i) == '#'){
                idxs.add(i);
            }
        }
        for (int i = 0; i < idxs.size(); i++) {
            desc = desc.replaceFirst("#", getParam(i).toString());
        }
        return desc;
    }

    default void addParam(Object param) {
        params.add(param);
    }

    default Object getParam(int idx) {
        return params.get(idx);
    }
}
