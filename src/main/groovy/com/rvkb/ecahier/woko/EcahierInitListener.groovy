package com.rvkb.ecahier.woko

import woko.persistence.ObjectStore
import woko.users.UserManager
import woko.hbcompass.HibernateCompassWokoInitListener
import woko.users.UsernameResolutionStrategy
import woko.auth.builtin.SessionUsernameResolutionStrategy

class EcahierInitListener extends HibernateCompassWokoInitListener {

    public static final String DEFAULT_FALLBACK_ROLE = "eguest"
    private EcahierStore store

    @Override
    protected ObjectStore createObjectStore() {
        List<String> packageNames = getPackageNamesFromConfig(CTX_PARAM_PACKAGE_NAMES);
        store = new EcahierStore(packageNames)
        return store
    }

    @Override
    protected UserManager createUserManager() {
        new EcahierUserManager(store).createDefaultUsers()
    }

    @Override
    protected UsernameResolutionStrategy createUsernameResolutionStrategy() {
        new SessionUsernameResolutionStrategy()
    }

    @Override
    protected List<String> createFallbackRoles() {
        return Arrays.asList(DEFAULT_FALLBACK_ROLE);
    }


}
