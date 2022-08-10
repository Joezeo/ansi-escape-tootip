package com.toocol.plugin.tooltip.search;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/7 17:27
 * @version: 0.0.1
 */
public enum ColorClut {
    Snow("Snow ", "255 250 250", "#FFFAFA"),
    GhostWhite("GhostWhite", "248 248 255", "#F8F8FF"),
    WhiteSmoke("WhiteSmoke", "245 245 245", "#F5F5F5"),
    Gainsboro("Gainsboro", "220 220 22", "#DCDCDC"),
    FloralWhite("FloralWhite", "255 250 240", "#FFFAF0"),
    OldLace("OldLace", "253 245 230", "#FDF5E6"),
    Linen("Linen", "250 240 230", "#FAF0E6"),
    AntiqueWhite("AntiqueWhite", "250 235 215", "#FAEBD7"),
    PapayaWhip("PapayaWhip", "255 239 213", "#FFEFD5"),
    BlanchedAlmond("BlanchedAlmond", "255 235 205", "#FFEBCD"),
    Bisque("Bisque", "255 228 196", "#FFE4C4"),
    PeachPuff("PeachPuff", "255 218 185", "#FFDAB9"),
    NavajoWhite("NavajoWhite", "255 222 173", "#FFDEAD"),
    Moccasin("Moccasin", "255 228 181", "#FFE4B5"),
    Cornsilk("Cornsilk", "255 248 220", "#FFF8DC"),
    Ivory("Ivory", "255 255 240", "#FFFFF0"),
    LemonChiffon("LemonChiffon", "255 250 205", "#FFFACD"),
    Seashell("Seashell", "255 245 238", "#FFF5EE"),
    Honeydew("Honeydew", "240 255 240", "#F0FFF0"),
    MintCream("MintCream", "245 255 250", "#F5FFFA"),
    Azure("Azure", "240 255 255", "#F0FFFF"),
    AliceBlue("AliceBlue", "240 248 255", "#F0F8FF"),
    lavender("lavender", "230 230 250", "#E6E6FA"),
    LavenderBlush("LavenderBlush", "255 240 245", "#FFF0F5"),
    MistyRose("MistyRose", "255 228 225", "#FFE4E1"),
    White("White", "255 255 255", "#FFFFFF"),
    Black("Black", "0 0 0", "#000000"),
    DarkSlateGray("DarkSlateGray", "47 79 79", "#2F4F4F"),
    DimGrey("DimGrey", "105 105 105", "#696969"),
    SlateGrey("SlateGrey", "112 128 144", "#708090"),
    LightSlateGray("LightSlateGray", "119 136 153", "#778899"),
    Grey("Grey", "190 190 190", "#BEBEBE"),
    LightGray("LightGray", "211 211 211", "#D3D3D3"),
    MidnightBlue("MidnightBlue", "25 25 112", "#191970"),
    NavyBlue("NavyBlue", "0 0 128", "#000080"),
    CornflowerBlue("CornflowerBlue", "100 149 237", "#6495ED"),
    DarkSlateBlue("DarkSlateBlue", "72 61 139", "#483D8B"),
    SlateBlue("SlateBlue", "106 90 205", "#6A5ACD"),
    MediumSlateBlue("MediumSlateBlue", "123 104 238", "#7B68EE"),
    LightSlateBlue("LightSlateBlue", "132 112 255", "#8470FF"),
    MediumBlue("MediumBlue", "0 0 205", "#0000CD"),
    RoyalBlue("RoyalBlue", "65 105 225", "#4169E1"),
    Blue("Blue ", "0 0 255", "#0000FF"),
    DodgerBlue("DodgerBlue", "30 144 255", "#1E90FF"),
    DeepSkyBlue("DeepSkyBlue", "0 191 255", "#00BFFF"),
    SkyBlue("SkyBlue", "135 206 235", "#87CEEB"),
    LightSkyBlue("LightSkyBlue", "135 206 250", "#87CEFA"),
    SteelBlue("SteelBlue", "70 130 180", "#4682B4"),
    LightSteelBlue("LightSteelBlue", "176 196 222", "#B0C4DE"),
    LightBlue("LightBlue", "173 216 230", "#ADD8E6"),
    PowderBlue("PowderBlue", "176 224 230", "#B0E0E6"),
    PaleTurquoise("PaleTurquoise", "175 238 238", "#AFEEEE"),
    DarkTurquoise("DarkTurquoise", "0 206 209", "#00CED1"),
    MediumTurquoise("MediumTurquoise", "72 209 204", "#48D1CC"),
    Turquoise("Turquoise", "64 224 208", "#40E0D0"),
    Cyan("Cyan ", "0 255 255", "#00FFFF"),
    LightCyan("LightCyan", "224 255 255", "#E0FFFF"),
    CadetBlue("CadetBlue", "95 158 160", "#5F9EA0"),
    MediumAquamarine("MediumAquamarine", "102 205 170", "#66CDAA"),
    Aquamarine("Aquamarine", "127 255 212", "#7FFFD4"),
    DarkGreen("DarkGreen", "0 100 0", "#006400"),
    DarkOliveGreen("DarkOliveGreen", "85 107 47", "#556B2F"),
    DarkSeaGreen("DarkSeaGreen", "143 188 143", "#8FBC8F"),
    SeaGreen("SeaGreen", "46 139 87", "#2E8B57"),
    MediumSeaGreen("MediumSeaGreen", "60 179 113", "#3CB371"),
    LightSeaGreen("LightSeaGreen", "32 178 170", "#20B2AA"),
    PaleGreen("PaleGreen", "152 251 152", "#98FB98"),
    SpringGreen("SpringGreen", "0 255 127", "#00FF7F"),
    LawnGreen("LawnGreen", "124 252 0", "#7CFC00"),
    Green("Green", "0 255 0", "#00FF00"),
    Chartreuse("Chartreuse", "127 255 0", "#7FFF00"),
    MedSpringGreen("MedSpringGreen", "0 250 154", "#00FA9A"),
    GreenYellow("GreenYellow", "173 255 47", "#ADFF2F"),
    LimeGreen("LimeGreen", "50 205 50", "#32CD32"),
    YellowGreen("YellowGreen", "154 205 50", "#9ACD32"),
    ForestGreen("ForestGreen", "34 139 34", "#228B22"),
    OliveDrab("OliveDrab", "107 142 35", "#6B8E23"),
    DarkKhaki("DarkKhaki", "189 183 107", "#BDB76B"),
    PaleGoldenrod("PaleGoldenrod", "238 232 170", "#EEE8AA"),
    LtGoldenrodYello("LtGoldenrodYello", "250 250 210", "#FAFAD2"),
    LightYellow("LightYellow", "255 255 224", "#FFFFE0"),
    Yellow("Yellow", "255 255 0", "#FFFF00"),
    Gold("Gold ", "255 215 0", "#FFD700"),
    LightGoldenrod("LightGoldenrod", "238 221 130", "#EEDD82"),
    goldenrod("goldenrod", "218 165 32", "#DAA520"),
    DarkGoldenrod("DarkGoldenrod", "184 134 11", "#B8860B"),
    RosyBrown("RosyBrown", "188 143 143", "#BC8F8F"),
    IndianRed("IndianRed", "205 92 92", "#CD5C5C"),
    SaddleBrown("SaddleBrown", "139 69 19", "#8B4513"),
    Sienna("Sienna", "160 82 45", "#A0522D"),
    Peru("Peru ", "205 133 63", "#CD853F"),
    Burlywood("Burlywood", "222 184 135", "#DEB887"),
    Beige("Beige", "245 245 220", "#F5F5DC"),
    Wheat("Wheat", "245 222 179", "#F5DEB3"),
    SandyBrown("SandyBrown", "244 164 96", "#F4A460"),
    Tan("Tan ", "210 180 140", "#D2B48C"),
    Chocolate("Chocolate", "210 105 30", "#D2691E"),
    Firebrick("Firebrick", "178 34 34", "#B22222"),
    Brown("Brown", "165 42 42", "#A52A2A"),
    DarkSalmon("DarkSalmon", "233 150 122", "#E9967A"),
    Salmon("Salmon", "250 128 114", "#FA8072"),
    LightSalmon("LightSalmon", "255 160 122", "#FFA07A"),
    Orange("Orange", "255 165 0", "#FFA500"),
    DarkOrange("DarkOrange", "255 140 0", "#FF8C00"),
    Coral("Coral", "255 127 80", "#FF7F50"),
    LightCoral("LightCoral", "240 128 128", "#F08080"),
    Tomato("Tomato", "255 99 71", "#FF6347"),
    OrangeRed("OrangeRed", "255 69 0", "#FF4500"),
    Red("Red ", "255 0 0", "#FF0000"),
    HotPink("HotPink", "255 105 180", "#FF69B4"),
    DeepPink("DeepPink", "255 20 147", "#FF1493"),
    Pink("Pink ", "255 192 203", "#FFC0CB"),
    LightPink("LightPink", "255 182 193", "#FFB6C1"),
    PaleVioletRed("PaleVioletRed", "219 112 147", "#DB7093"),
    Maroon("Maroon", "176 48 96", "#B03060"),
    MediumVioletRed("MediumVioletRed", "199 21 133", "#C71585"),
    VioletRed("VioletRed", "208 32 144", "#D02090"),
    Magenta("Magenta", "255 0 255", "#FF00FF"),
    Violet("Violet", "238 130 238", "#EE82EE"),
    Plum("Plum ", "221 160 221", "#DDA0DD"),
    Orchid("Orchid", "218 112 214", "#DA70D6"),
    MediumOrchid("MediumOrchid", "186 85 211", "#BA55D3"),
    DarkOrchid("DarkOrchid", "153 50 204", "#9932CC"),
    DarkViolet("DarkViolet", "148 0 211", "#9400D3"),
    BlueViolet("BlueViolet", "138 43 226", "#8A2BE2"),
    Purple("Purple", "160 32 240", "#A020F0"),
    MediumPurple("MediumPurple", "147 112 219", "#9370DB"),
    Thistle("Thistle", "216 191 216", "#D8BFD8"),
    Snow1("Snow1", "255 250 250", "#FFFAFA"),
    Snow2("Snow2", "238 233 233", "#EEE9E9"),
    Snow3("Snow3", "205 201 201", "#CDC9C9"),
    Snow4("Snow4", "139 137 137", "#8B8989"),
    Seashell1("Seashell1", "255 245 238", "#FFF5EE"),
    Seashell2("Seashell2", "238 229 222", "#EEE5DE"),
    Seashell3("Seashell3", "205 197 191", "#CDC5BF"),
    Seashell4("Seashell4", "139 134 130", "#8B8682"),
    AntiqueWhite1("AntiqueWhite1", "255 239 219", "#FFEFDB"),
    AntiqueWhite2("AntiqueWhite2", "238 223 204", "#EEDFCC"),
    AntiqueWhite3("AntiqueWhite3", "205 192 176", "#CDC0B0"),
    AntiqueWhite4("AntiqueWhite4", "139 131 120", "#8B8378"),
    Bisque1("Bisque1", "255 228 196", "#FFE4C4"),
    Bisque2("Bisque2", "238 213 183", "#EED5B7"),
    Bisque3("Bisque3", "205 183 158", "#CDB79E"),
    Bisque4("Bisque4", "139 125 107", "#8B7D6B"),
    PeachPuff1("PeachPuff1", "255 218 185", "#FFDAB9"),
    PeachPuff2("PeachPuff2", "238 203 173", "#EECBAD"),
    PeachPuff3("PeachPuff3", "205 175 149", "#CDAF95"),
    PeachPuff4("PeachPuff4", "139 119 101", "#8B7765"),
    NavajoWhite1("NavajoWhite1", "255 222 173", "#FFDEAD"),
    NavajoWhite2("NavajoWhite2", "238 207 161", "#EECFA1"),
    NavajoWhite3("NavajoWhite3", "205 179 139", "#CDB38B"),
    NavajoWhite4("NavajoWhite4", "139 121 94", "#8B795E"),
    LemonChiffon1("LemonChiffon1", "255 250 205", "#FFFACD"),
    LemonChiffon2("LemonChiffon2", "238 233 191", "#EEE9BF"),
    LemonChiffon3("LemonChiffon3", "205 201 165", "#CDC9A5"),
    LemonChiffon4("LemonChiffon4", "139 137 112", "#8B8970"),
    Cornsilk1("Cornsilk1", "255 248 220", "#FFF8DC"),
    Cornsilk2("Cornsilk2", "238 232 205", "#EEE8CD"),
    Cornsilk3("Cornsilk3", "205 200 177", "#CDC8B1"),
    Cornsilk4("Cornsilk4", "139 136 120", "#8B8878"),
    Ivory1("Ivory1", "255 255 240", "#FFFFF0"),
    Ivory2("Ivory2", "238 238 224", "#EEEEE0"),
    Ivory3("Ivory3", "205 205 193", "#CDCDC1"),
    Ivory4("Ivory4", "139 139 131", "#8B8B83"),
    Honeydew1("Honeydew1", "240 255 240", "#F0FFF0"),
    Honeydew2("Honeydew2", "224 238 224", "#E0EEE0"),
    Honeydew3("Honeydew3", "193 205 193", "#C1CDC1"),
    Honeydew4("Honeydew4", "131 139 131", "#838B83"),
    LavenderBlush1("LavenderBlush1", "255 240 245", "#FFF0F5"),
    LavenderBlush2("LavenderBlush2", "238 224 229", "#EEE0E5"),
    LavenderBlush3("LavenderBlush3", "205 193 197", "#CDC1C5"),
    LavenderBlush4("LavenderBlush4", "139 131 134", "#8B8386"),
    MistyRose1("MistyRose1", "255 228 225", "#FFE4E1"),
    MistyRose2("MistyRose2", "238 213 210", "#EED5D2"),
    MistyRose3("MistyRose3", "205 183 181", "#CDB7B5"),
    MistyRose4("MistyRose4", "139 125 123", "#8B7D7B"),
    Azure1("Azure1", "240 255 255", "#F0FFFF"),
    Azure2("Azure2", "224 238 238", "#E0EEEE"),
    Azure3("Azure3", "193 205 205", "#C1CDCD"),
    Azure4("Azure4", "131 139 139", "#838B8B"),
    SlateBlue1("SlateBlue1", "131 111 255", "#836FFF"),
    SlateBlue2("SlateBlue2", "122 103 238", "#7A67EE"),
    SlateBlue3("SlateBlue3", "105 89 205", "#6959CD"),
    SlateBlue4("SlateBlue4", "71 60 139", "#473C8B"),
    RoyalBlue1("RoyalBlue1", "72 118 255", "#4876FF"),
    RoyalBlue2("RoyalBlue2", "67 110 238", "#436EEE"),
    RoyalBlue3("RoyalBlue3", "58 95 205", "#3A5FCD"),
    RoyalBlue4("RoyalBlue4", "39 64 139", "#27408B"),
    Blue1("Blue1", "0 0 255", "#0000FF"),
    Blue2("Blue2", "0 0 238", "#0000EE"),
    Blue3("Blue3", "0 0 205", "#0000CD"),
    Blue4("Blue4", "0 0 139", "#00008B"),
    DodgerBlue1("DodgerBlue1", "30 144 255", "#1E90FF"),
    DodgerBlue2("DodgerBlue2", "28 134 238", "#1C86EE"),
    DodgerBlue3("DodgerBlue3", "24 116 205", "#1874CD"),
    DodgerBlue4("DodgerBlue4", "16 78 139", "#104E8B"),
    SteelBlue1("SteelBlue1", "99 184 255", "#63B8FF"),
    SteelBlue2("SteelBlue2", "92 172 238", "#5CACEE"),
    SteelBlue3("SteelBlue3", "79 148 205", "#4F94CD"),
    SteelBlue4("SteelBlue4", "54 100 139", "#36648B"),
    DeepSkyBlue1("DeepSkyBlue1", "0 191 255", "#00BFFF"),
    DeepSkyBlue2("DeepSkyBlue2", "0 178 238", "#00B2EE"),
    DeepSkyBlue3("DeepSkyBlue3", "0 154 205", "#009ACD"),
    DeepSkyBlue4("DeepSkyBlue4", "0 104 139", "#00688B"),
    SkyBlue1("SkyBlue1", "135 206 255", "#87CEFF"),
    SkyBlue2("SkyBlue2", "126 192 238", "#7EC0EE"),
    SkyBlue3("SkyBlue3", "108 166 205", "#6CA6CD"),
    SkyBlue4("SkyBlue4", "74 112 139", "#4A708B"),
    LightSkyBlue1("LightSkyBlue1", "176 226 255", "#B0E2FF"),
    LightSkyBlue2("LightSkyBlue2", "164 211 238", "#A4D3EE"),
    LightSkyBlue3("LightSkyBlue3", "141 182 205", "#8DB6CD"),
    LightSkyBlue4("LightSkyBlue4", "96 123 139", "#607B8B"),
    SlateGray1("SlateGray1", "198 226 255", "#C6E2FF"),
    SlateGray2("SlateGray2", "185 211 238", "#B9D3EE"),
    SlateGray3("SlateGray3", "159 182 205", "#9FB6CD"),
    SlateGray4("SlateGray4", "108 123 139", "#6C7B8B"),
    LightSteelBlue1("LightSteelBlue1", "202 225 255", "#CAE1FF"),
    LightSteelBlue2("LightSteelBlue2", "188 210 238", "#BCD2EE"),
    LightSteelBlue3("LightSteelBlue3", "162 181 205", "#A2B5CD"),
    LightSteelBlue4("LightSteelBlue4", "110 123 139", "#6E7B8B"),
    LightBlue1("LightBlue1", "191 239 255", "#BFEFFF"),
    LightBlue2("LightBlue2", "178 223 238", "#B2DFEE"),
    LightBlue3("LightBlue3", "154 192 205", "#9AC0CD"),
    LightBlue4("LightBlue4", "104 131 139", "#68838B"),
    LightCyan1("LightCyan1", "224 255 255", "#E0FFFF"),
    LightCyan2("LightCyan2", "209 238 238", "#D1EEEE"),
    LightCyan3("LightCyan3", "180 205 205", "#B4CDCD"),
    LightCyan4("LightCyan4", "122 139 139", "#7A8B8B"),
    PaleTurquoise1("PaleTurquoise1", "187 255 255", "#BBFFFF"),
    PaleTurquoise2("PaleTurquoise2", "174 238 238", "#AEEEEE"),
    PaleTurquoise3("PaleTurquoise3", "150 205 205", "#96CDCD"),
    PaleTurquoise4("PaleTurquoise4", "102 139 139", "#668B8B"),
    CadetBlue1("CadetBlue1", "152 245 255", "#98F5FF"),
    CadetBlue2("CadetBlue2", "142 229 238", "#8EE5EE"),
    CadetBlue3("CadetBlue3", "122 197 205", "#7AC5CD"),
    CadetBlue4("CadetBlue4", "83 134 139", "#53868B"),
    Turquoise1("Turquoise1", "0 245 255", "#00F5FF"),
    Turquoise2("Turquoise2", "0 229 238", "#00E5EE"),
    Turquoise3("Turquoise3", "0 197 205", "#00C5CD"),
    Turquoise4("Turquoise4", "0 134 139", "#00868B"),
    Cyan1("Cyan1", "0 255 255", "#00FFFF"),
    Cyan2("Cyan2", "0 238 238", "#00EEEE"),
    Cyan3("Cyan3", "0 205 205", "#00CDCD"),
    Cyan4("Cyan4", "0 139 139", "#008B8B"),
    DarkSlateGray1("DarkSlateGray1", "151 255 255", "#97FFFF"),
    DarkSlateGray2("DarkSlateGray2", "141 238 238", "#8DEEEE"),
    DarkSlateGray3("DarkSlateGray3", "121 205 205", "#79CDCD"),
    DarkSlateGray4("DarkSlateGray4", "82 139 139", "#528B8B"),
    Aquamarine1("Aquamarine1", "127 255 212", "#7FFFD4"),
    Aquamarine2("Aquamarine2", "118 238 198", "#76EEC6"),
    Aquamarine3("Aquamarine3", "102 205 170", "#66CDAA"),
    Aquamarine4("Aquamarine4", "69 139 116", "#458B74"),
    DarkSeaGreen1("DarkSeaGreen1", "193 255 193", "#C1FFC1"),
    DarkSeaGreen2("DarkSeaGreen2", "180 238 180", "#B4EEB4"),
    DarkSeaGreen3("DarkSeaGreen3", "155 205 155", "#9BCD9B"),
    DarkSeaGreen4("DarkSeaGreen4", "105 139 105", "#698B69"),
    SeaGreen1("SeaGreen1", "84 255 159", "#54FF9F"),
    SeaGreen2("SeaGreen2", "78 238 148", "#4EEE94"),
    SeaGreen3("SeaGreen3", "67 205 128", "#43CD80"),
    SeaGreen4("SeaGreen4", "46 139 87", "#2E8B57"),
    PaleGreen1("PaleGreen1", "154 255 154", "#9AFF9A"),
    PaleGreen2("PaleGreen2", "144 238 144", "#90EE90"),
    PaleGreen3("PaleGreen3", "124 205 124", "#7CCD7C"),
    PaleGreen4("PaleGreen4", "84 139 84", "#548B54"),
    SpringGreen1("SpringGreen1", "0 255 127", "#00FF7F"),
    SpringGreen2("SpringGreen2", "0 238 118", "#00EE76"),
    SpringGreen3("SpringGreen3", "0 205 102", "#00CD66"),
    SpringGreen4("SpringGreen4", "0 139 69", "#008B45"),
    Green1("Green1", "0 255 0", "#00FF00"),
    Green2("Green2", "0 238 0", "#00EE00"),
    Green3("Green3", "0 205 0", "#00CD00"),
    Green4("Green4", "0 139 0", "#008B00"),
    Chartreuse1("Chartreuse1", "127 255 0", "#7FFF00"),
    Chartreuse2("Chartreuse2", "118 238 0", "#76EE00"),
    Chartreuse3("Chartreuse3", "102 205 0", "#66CD00"),
    Chartreuse4("Chartreuse4", "69 139 0", "#458B00"),
    OliveDrab1("OliveDrab1", "192 255 62", "#C0FF3E"),
    OliveDrab2("OliveDrab2", "179 238 58", "#B3EE3A"),
    OliveDrab3("OliveDrab3", "154 205 50", "#9ACD32"),
    OliveDrab4("OliveDrab4", "105 139 34", "#698B22"),
    DarkOliveGreen1("DarkOliveGreen1", "202 255 112", "#CAFF70"),
    DarkOliveGreen2("DarkOliveGreen2", "188 238 104", "#BCEE68"),
    DarkOliveGreen3("DarkOliveGreen3", "162 205 90", "#A2CD5A"),
    DarkOliveGreen4("DarkOliveGreen4", "110 139 61", "#6E8B3D"),
    Khaki1("Khaki1", "255 246 143", "#FFF68F"),
    Khaki2("Khaki2", "238 230 133", "#EEE685"),
    Khaki3("Khaki3", "205 198 115", "#CDC673"),
    Khaki4("Khaki4", "139 134 78", "#8B864E"),
    LightGoldenrod1("LightGoldenrod1", "255 236 139", "#FFEC8B"),
    LightGoldenrod2("LightGoldenrod2", "238 220 130", "#EEDC82"),
    LightGoldenrod3("LightGoldenrod3", "205 190 112", "#CDBE70"),
    LightGoldenrod4("LightGoldenrod4", "139 129 76", "#8B814C"),
    LightYellow1("LightYellow1", "255 255 224", "#FFFFE0"),
    LightYellow2("LightYellow2", "238 238 209", "#EEEED1"),
    LightYellow3("LightYellow3", "205 205 180", "#CDCDB4"),
    LightYellow4("LightYellow4", "139 139 122", "#8B8B7A"),
    Yellow1("Yellow1", "255 255 0", "#FFFF00"),
    Yellow2("Yellow2", "238 238 0", "#EEEE00"),
    Yellow3("Yellow3", "205 205 0", "#CDCD00"),
    Yellow4("Yellow4", "139 139 0", "#8B8B00"),
    Gold1("Gold1", "255 215 0", "#FFD700"),
    Gold2("Gold2", "238 201 0", "#EEC900"),
    Gold3("Gold3", "205 173 0", "#CDAD00"),
    Gold4("Gold4", "139 117 0", "#8B7500"),
    Goldenrod1("Goldenrod1", "255 193 37", "#FFC125"),
    Goldenrod2("Goldenrod2", "238 180 34", "#EEB422"),
    Goldenrod3("Goldenrod3", "205 155 29", "#CD9B1D"),
    Goldenrod4("Goldenrod4", "139 105 20", "#8B6914"),
    DarkGoldenrod1("DarkGoldenrod1", "255 185 15", "#FFB90F"),
    DarkGoldenrod2("DarkGoldenrod2", "238 173 14", "#EEAD0E"),
    DarkGoldenrod3("DarkGoldenrod3", "205 149 12", "#CD950C"),
    DarkGoldenrod4("DarkGoldenrod4", "139 101 8", "#8B658B"),
    RosyBrown1("RosyBrown1", "255 193 193", "#FFC1C1"),
    RosyBrown2("RosyBrown2", "238 180 180", "#EEB4B4"),
    RosyBrown3("RosyBrown3", "205 155 155", "#CD9B9B"),
    RosyBrown4("RosyBrown4", "139 105 105", "#8B6969"),
    IndianRed1("IndianRed1", "255 106 106", "#FF6A6A"),
    IndianRed2("IndianRed2", "238 99 99", "#EE6363"),
    IndianRed3("IndianRed3", "205 85 85", "#CD5555"),
    IndianRed4("IndianRed4", "139 58 58", "#8B3A3A"),
    Sienna1("Sienna1", "255 130 71", "#FF8247"),
    Sienna2("Sienna2", "238 121 66", "#EE7942"),
    Sienna3("Sienna3", "205 104 57", "#CD6839"),
    Sienna4("Sienna4", "139 71 38", "#8B4726"),
    Burlywood1("Burlywood1", "255 211 155", "#FFD39B"),
    Burlywood2("Burlywood2", "238 197 145", "#EEC591"),
    Burlywood3("Burlywood3", "205 170 125", "#CDAA7D"),
    Burlywood4("Burlywood4", "139 115 85", "#8B7355"),
    Wheat1("Wheat1", "255 231 186", "#FFE7BA"),
    Wheat2("Wheat2", "238 216 174", "#EED8AE"),
    Wheat3("Wheat3", "205 186 150", "#CDBA96"),
    Wheat4("Wheat4", "139 126 102", "#8B7E66"),
    Tan1("Tan1 ", "255 165 79", "#FFA54F"),
    Tan2("Tan2 ", "238 154 73", "#EE9A49"),
    Tan3("Tan3 ", "205 133 63", "#CD853F"),
    Tan4("Tan4 ", "139 90 43", "#8B5A2B"),
    Chocolate1("Chocolate1", "255 127 36", "#FF7F24"),
    Chocolate2("Chocolate2", "238 118 33", "#EE7621"),
    Chocolate3("Chocolate3", "205 102 29", "#CD661D"),
    Chocolate4("Chocolate4", "139 69 19", "#8B4513"),
    Firebrick1("Firebrick1", "255 48 48", "#FF3030"),
    Firebrick2("Firebrick2", "238 44 44", "#EE2C2C"),
    Firebrick3("Firebrick3", "205 38 38", "#CD2626"),
    Firebrick4("Firebrick4", "139 26 26", "#8B1A1A"),
    Brown1("Brown1", "255 64 64", "#FF4040"),
    Brown2("Brown2", "238 59 59", "#EE3B3B"),
    Brown3("Brown3", "205 51 51", "#CD3333"),
    Brown4("Brown4", "139 35 35", "#8B2323"),
    Salmon1("Salmon1", "255 140 105", "#FF8C69"),
    Salmon2("Salmon2", "238 130 98", "#EE8262"),
    Salmon3("Salmon3", "205 112 84", "#CD7054"),
    Salmon4("Salmon4", "139 76 57", "#8B4C39"),
    LightSalmon1("LightSalmon1", "255 160 122", "#FFA07A"),
    LightSalmon2("LightSalmon2", "238 149 114", "#EE9572"),
    LightSalmon3("LightSalmon3", "205 129 98", "#CD8162"),
    LightSalmon4("LightSalmon4", "139 87 66", "#8B5742"),
    Orange1("Orange1", "255 165 0", "#FFA500"),
    Orange2("Orange2", "238 154 0", "#EE9A00"),
    Orange3("Orange3", "205 133 0", "#CD8500"),
    Orange4("Orange4", "139 90 0", "#8B5A00"),
    DarkOrange1("DarkOrange1", "255 127 0", "#FF7F00"),
    DarkOrange2("DarkOrange2", "238 118 0", "#EE7600"),
    DarkOrange3("DarkOrange3", "205 102 0", "#CD6600"),
    DarkOrange4("DarkOrange4", "139 69 0", "#8B4500"),
    Coral1("Coral1", "255 114 86", "#FF7256"),
    Coral2("Coral2", "238 106 80", "#EE6A50"),
    Coral3("Coral3", "205 91 69", "#CD5B45"),
    Coral4("Coral4", "139 62 47", "#8B3E2F"),
    Tomato1("Tomato1", "255 99 71", "#FF6347"),
    Tomato2("Tomato2", "238 92 66", "#EE5C42"),
    Tomato3("Tomato3", "205 79 57", "#CD4F39"),
    Tomato4("Tomato4", "139 54 38", "#8B3626"),
    OrangeRed1("OrangeRed1", "255 69 0", "#FF4500"),
    OrangeRed2("OrangeRed2", "238 64 0", "#EE4000"),
    OrangeRed3("OrangeRed3", "205 55 0", "#CD3700"),
    OrangeRed4("OrangeRed4", "139 37 0", "#8B2500"),
    Red1("Red1 ", "255 0 0", "#FF0000"),
    Red2("Red2 ", "238 0 0", "#EE0000"),
    Red3("Red3 ", "205 0 0", "#CD0000"),
    Red4("Red4 ", "139 0 0", "#8B0000"),
    DeepPink1("DeepPink1", "255 20 147", "#FF1493"),
    DeepPink2("DeepPink2", "238 18 137", "#EE1289"),
    DeepPink3("DeepPink3", "205 16 118", "#CD1076"),
    DeepPink4("DeepPink4", "139 10 80", "#8B0A50"),
    HotPink1("HotPink1", "255 110 180", "#FF6EB4"),
    HotPink2("HotPink2", "238 106 167", "#EE6AA7"),
    HotPink3("HotPink3", "205 96 144", "#CD6090"),
    HotPink4("HotPink4", "139 58 98", "#8B3A62"),
    Pink1("Pink1", "255 181 197", "#FFB5C5"),
    Pink2("Pink2", "238 169 184", "#EEA9B8"),
    Pink3("Pink3", "205 145 158", "#CD919E"),
    Pink4("Pink4", "139 99 108", "#8B636C"),
    LightPink1("LightPink1", "255 174 185", "#FFAEB9"),
    LightPink2("LightPink2", "238 162 173", "#EEA2AD"),
    LightPink3("LightPink3", "205 140 149", "#CD8C95"),
    LightPink4("LightPink4", "139 95 101", "#8B5F65"),
    PaleVioletRed1("PaleVioletRed1", "255 130 171", "#FF82AB"),
    PaleVioletRed2("PaleVioletRed2", "238 121 159", "#EE799F"),
    PaleVioletRed3("PaleVioletRed3", "205 104 137", "#CD6889"),
    PaleVioletRed4("PaleVioletRed4", "139 71 93", "#8B475D"),
    Maroon1("Maroon1", "255 52 179", "#FF34B3"),
    Maroon2("Maroon2", "238 48 167", "#EE30A7"),
    Maroon3("Maroon3", "205 41 144", "#CD2990"),
    Maroon4("Maroon4", "139 28 98", "#8B1C62"),
    VioletRed1("VioletRed1", "255 62 150", "#FF3E96"),
    VioletRed2("VioletRed2", "238 58 140", "#EE3A8C"),
    VioletRed3("VioletRed3", "205 50 120", "#CD3278"),
    VioletRed4("VioletRed4", "139 34 82", "#8B2252"),
    Magenta1("Magenta1", "255 0 255", "#FF00FF"),
    Magenta2("Magenta2", "238 0 238", "#EE00EE"),
    Magenta3("Magenta3", "205 0 205", "#CD00CD"),
    Magenta4("Magenta4", "139 0 139", "#8B008B"),
    Orchid1("Orchid1", "255 131 250", "#FF83FA"),
    Orchid2("Orchid2", "238 122 233", "#EE7AE9"),
    Orchid3("Orchid3", "205 105 201", "#CD69C9"),
    Orchid4("Orchid4", "139 71 137", "#8B4789"),
    Plum1("Plum1", "255 187 255", "#FFBBFF"),
    Plum2("Plum2", "238 174 238", "#EEAEEE"),
    Plum3("Plum3", "205 150 205", "#CD96CD"),
    Plum4("Plum4", "139 102 139", "#8B668B"),
    MediumOrchid1("MediumOrchid1", "224 102 255", "#E066FF"),
    MediumOrchid2("MediumOrchid2", "209 95 238", "#D15FEE"),
    MediumOrchid3("MediumOrchid3", "180 82 205", "#B452CD"),
    MediumOrchid4("MediumOrchid4", "122 55 139", "#7A378B"),
    DarkOrchid1("DarkOrchid1", "191 62 255", "#BF3EFF"),
    DarkOrchid2("DarkOrchid2", "178 58 238", "#B23AEE"),
    DarkOrchid3("DarkOrchid3", "154 50 205", "#9A32CD"),
    DarkOrchid4("DarkOrchid4", "104 34 139", "#68228B"),
    Purple1("Purple1", "155 48 255", "#9B30FF"),
    Purple2("Purple2", "145 44 238", "#912CEE"),
    Purple3("Purple3", "125 38 205", "#7D26CD"),
    Purple4("Purple4", "85 26 139", "#551A8B"),
    MediumPurple1("MediumPurple1", "171 130 255", "#AB82FF"),
    MediumPurple2("MediumPurple2", "159 121 238", "#9F79EE"),
    MediumPurple3("MediumPurple3", "137 104 205", "#8968CD"),
    MediumPurple4("MediumPurple4", "93 71 139", "#5D478B"),
    Thistle1("Thistle1", "255 225 255", "#FFE1FF"),
    Thistle2("Thistle2", "238 210 238", "#EED2EE"),
    Thistle3("Thistle3", "205 181 205", "#CDB5CD"),
    Thistle4("Thistle4", "139 123 139", "#8B7B8B"),
    grey11("grey11", "28 28 28", "#1C1C1C"),
    grey21("grey21", "54 54 54", "#363636"),
    grey31("grey31", "79 79 79", "#4F4F4F"),
    grey41("grey41", "105 105 105", "#696969"),
    grey51("grey51", "130 130 130", "#828282"),
    grey61("grey61", "156 156 156", "#9C9C9C"),
    grey71("grey71", "181 181 181", "#B5B5B5"),
    gray81("gray81", "207 207 207", "#CFCFCF"),
    gray91("gray91", "232 232 232", "#E8E8E8"),
    DarkGrey("DarkGrey", "169 169 169", "#A9A9A9"),
    DarkBlue("DarkBlue", "0 0 139", "#00008B"),
    DarkCyan("DarkCyan", "0 139 139", "#008B8B"),
    DarkMagenta("DarkMagenta", "139 0 139", "#8B008B"),
    DarkRed("DarkRed", "139 0 0", "#8B0000"),
    LightGreen("LightGreen", "144 238 144", "#90EE90"),
    ;
    private static final Map<String, ColorClut> rgbColorClutMap = new HashMap<>();
    private static final Map<String, ColorClut> hexColorClutMap = new HashMap<>();

    static {
        for (ColorClut clut : values()) {
            rgbColorClutMap.put(clut.rgb, clut);
            hexColorClutMap.put(clut.hex, clut);
        }
    }

    public final String name;
    public final String rgb;
    public final String hex;

    ColorClut(String name, String rgb, String hex) {
        this.name = name;
        this.rgb = rgb;
        this.hex = hex;
    }

    ColorClut rgbOf(String rgb) {
        return rgbColorClutMap.get(rgb);
    }

    ColorClut hexOf(String hex) {
        return hexColorClutMap.get(hex);
    }
}
