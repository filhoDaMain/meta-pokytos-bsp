SUMMARY = "Firmware blobs for Orange Pi Bluetooth"
DESCRIPTION = "Proprietary Software from orangepi-xunlong. \
Commercial usage may be restricted. \
"
SECTION = "firmware"

# NOTE: License "assumed" to be Proprietary, as no License disclosure exists
# in any of Orange Pi repos.
# Commercial usage may be restricted (?).
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

SRCREV = "dc163b0ed2e0272d9ee31977a0e0a04884f0ae61"
SRC_URI = "git://github.com/orangepi-xunlong/firmware.git;branch=master;protocol=https"
S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware
    cp bt_configure_pskey.ini ${D}${nonarch_base_libdir}/firmware/bt_configure_pskey.ini
    cp bt_configure_rf.ini ${D}${nonarch_base_libdir}/firmware/bt_configure_rf.ini
}

FILES:${PN} = "\
    ${nonarch_base_libdir}/firmware/bt_configure_pskey.ini \
    ${nonarch_base_libdir}/firmware/bt_configure_rf.ini \
"
