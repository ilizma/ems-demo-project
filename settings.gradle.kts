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

    // region Ems
    ":ems-di",
    ":ems-flow",
    ":ems-flow-imp",
    ":ems-view",
    ":ems-view-imp",
    ":ems-presentation",
    ":ems-presentation-imp",
    ":ems-domain",
    ":ems-domain-imp",
    ":ems-data",
    ":ems-data-imp",
    // endregion

)
