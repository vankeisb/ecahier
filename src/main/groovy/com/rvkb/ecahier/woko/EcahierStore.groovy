package com.rvkb.ecahier.woko

import woko.util.WLogger
import woko.hbcompass.HibernateCompassStore

class EcahierStore extends HibernateCompassStore {

    private static final WLogger logger = WLogger.getLogger(EcahierStore.class)

    EcahierStore(List<String> packageNames) {
        super(packageNames)
    }

}
