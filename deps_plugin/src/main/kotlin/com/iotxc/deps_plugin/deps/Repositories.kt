package com.iotxc.deps_plugin.deps

/**
 * Author     : iot_xc
 * Date       : 2021/4/20
 * Version    : V1.0
 * Description: 描写描述
 */
object Repositories {

    var url                     = "http://10.10.96.219:8081/repository/"

    var router_compiler         = "${SlothCore.group}:router_compiler:${SlothCore.version}"
    var router_api              = "${SlothCore.group}:router-api:${SlothCore.version}"
    var router_annotation       = "${SlothCore.group}:router_annotation:${SlothCore.version}"
    var weaponryx               = "${SlothCore.group}:weaponryx:${SlothCore.version}"
    var weaponryx_plogger       = "${SlothCore.group}:weaponryx-plogger:${SlothCore.version}"
    var weaponryx_analysis      = "${SlothCore.group}:weaponryx_analysis:${SlothCore.version}"
    var weaponryx_utils         = "${SlothCore.group}:weaponryx-utils:${SlothCore.version}"
    var weaponryx_cachelib      = "${SlothCore.group}:weaponryx-cachelib:${SlothCore.version}"
    var weaponryx_rxlib         = "${SlothCore.group}:weaponryx-rxlib:${SlothCore.version}"

    private object SlothCore {
        var domain        = "pateo"
        var group         = "com.pateo.slothcore"
        var version       = Versions.sloth_default
        var packaging     = "aar"
    }
}