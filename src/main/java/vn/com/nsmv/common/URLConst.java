package vn.com.nsmv.common;

import java.io.File;

public class URLConst {

    private static final String api = "/api";
    public static final String LOGIN_FAIL = "/login?error=true";

    public static final String lang_support_regex = "/en/|/ja/|/vi/";
    public static final String lang_support = "en|ja|vi";
    private static final String lang = "/{locale:"+ lang_support +"}";
    public static final String loginSucess = "/";
    public static final String ROOT = "/";
    public static final String ROOT_LANG = lang + "/";
    public static class LOGIN {
        public static final String HOME = "/login";
        public static final String LOGOUT = "/logout";
        public static class CONTROLLER {
            public static final String HOME = lang + LOGIN.HOME;
            public static final String LOGOUT = lang + "/logout";
        }
    }
    public static final String PROFILE = "/profile";
    public static class USERS {
        public static final String HOME = "/users";
        public static class CONTROLLER {
            public static final String HOME = lang + DASHBOARD.HOME;
            public static final String PROFILE = USERS.HOME + "/profile";
        }
        public static class API {
            public static final String HOME = api + DASHBOARD.HOME;
        }
    }
    public static class DASHBOARD {
        public static final String HOME = "/dashboard";
        public static class CONTROLLER {
            public static final String HOME = lang + DASHBOARD.HOME;
        }
        public static class API {
            public static final String HOME = api + DASHBOARD.HOME;
        }
    }
}
