package com.company.electricitybillappp.api;

public class ApiManager {
    public static void setInstance(ApiManager instance) {
        ApiManager.instance = instance;
    }

    private static ApiManager instance;

    private ApiInterface apiImpl;
    private ApiService apiService;

    /**
     * Don't allow instances
     */
    private ApiManager() {

    }

    /**
     * Create a singleton instance of this class and provides
     * {@link ApiInterface} implementation using {@link NetworkManager} interface
     *
     * @return ApiManager
     */
    public static synchronized ApiManager getInstance() {

        if (instance == null) {
            instance = new ApiManager();
            instance.apiService = new NetworkManager(AppApplication.getInstance()).getService();
            instance.apiImpl = new ApiInterfaceImpl(instance.apiService);
        }

        return instance;
    }

    public ApiInterface getAPI() {
        return apiImpl;
    }
}
