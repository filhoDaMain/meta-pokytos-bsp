SUMMARY = "Linux kernel drivers for the Unisoc/Spreadtrum uwe5622 wireless connectivity chipset"
DESCRIPTION = "${SUMMARY}"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"
COMPATIBLE_MACHINE = "sun50i"

inherit module

BRANCH = "master"
SRCREV = "fa9d1a6703a93a85bcf68e865ebc2726474076ad"

SRC_URI = "\
    git://github.com/armbian/uwe5622.git;protocol=https;branch=${BRANCH} \
"

# Local patches
SRC_URI += "\
    file://0001-Makefile-Fix-Yocto-build.patch \
"

S = "${WORKDIR}/git"

# Pass uwe5622 source dir to its Makefile
EXTRA_OEMAKE:append = " S=${S}"

# Bluetooth and bsp-sdio modules build
EXTRA_OEMAKE:append = " \
    ${@bb.utils.contains("MACHINE_FEATURES", "bluetooth", "\
        CONFIG_AW_WIFI_DEVICE_UWE5622=y \
        CONFIG_AW_BIND_VERIFY=y \
        CONFIG_TTY_OVERY_SDIO=m \
    ", "", d)} \
"

# Wifi and bsp-sdio modules build
EXTRA_OEMAKE:append = " \
    ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "\
        CONFIG_AW_WIFI_DEVICE_UWE5622=y \
        CONFIG_WLAN_UWE5622=m \
        CONFIG_SPRDWL_NG=m \
        CONFIG_SPARD_WLAN_SUPPORT=y \
        CONFIG_SUNXI_ADDR_MGT=y \
        CONFIG_UNISOC_WIFI_PS=y \
    ", "", d)} \
"

# Delete unneeded files to avoid QA errors
# do_install:append() {
#     rm -rf ${D}/usr/include
# }

# Just to avoid QA errors
#FILES:${PN} += "/usr/"

RPROVIDES:${PN} += " \
    ${@bb.utils.contains("MACHINE_FEATURES", "bluetooth", "\
        kernel-module-sprdbt-tty \
        kernel-module-uwe5622-bsp-sdio \
    ", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "\
        kernel-module-sprdwl-ng \
        kernel-module-uwe5622-bsp-sdio \
    ", "", d)} \
"

#PACKAGES = "${PN}-wifi ${PN}-bluetooth"

#RPROVIDES:${PN}-wifi += "kernel-module-sprdwl-ng"
#deleteme KERNEL_MODULE_AUTOLOAD += "${PN}"
