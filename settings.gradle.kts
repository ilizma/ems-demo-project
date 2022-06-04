include(
    // View
    ":view-base",

    // Presentation
    ":presentation-base",

    // Test
    ":test-base",

    // resources
    ":resources",

    // region Api
    ":api-di",
    ":api",
    ":api-imp",
    // endregion

    // region App
    ":app",
    ":app-di",
    ":app-flow",
    ":app-view",
    // endregion

    // region Error Management
    ":error-management-di",
    ":error-management-view",
    ":error-management-view-imp",
    // endregion

    // region Dashboard
    ":dashboard-di",
    ":dashboard-view",
    ":dashboard-view-imp",
    ":dashboard-presentation",
    ":dashboard-presentation-imp",
    ":dashboard-domain",
    ":dashboard-domain-imp",
    ":dashboard-data",
    ":dashboard-data-imp",
    // endregion

)
