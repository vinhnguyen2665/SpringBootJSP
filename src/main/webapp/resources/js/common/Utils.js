class Utils {
    static getDataTableLang = () => {
        switch(lang) {
            case Constant.ja:
                return Constant.DATA_TABLE_JA
            case Constant.en:
                return Constant.DATA_TABLE_EN
            case Constant.vi:
                return Constant.DATA_TABLE_VI
            default:
                return Constant.DATA_TABLE_EN
        }
    }
    static getContextPath = () => {
        return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
    }
}
