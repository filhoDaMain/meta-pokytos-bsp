SUMMARY = "Systemd service to attach hci0 device (bluetooth)"
LICENSE = "GPL-2.0-only"
SECTION = "bluetooth"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

RDEPENDS:${PN} = "hciattach-opi"

inherit systemd
SYSTEMD_SERVICE:${PN} = "hciattach-opi-ttybt0.service"

SRC_URI = "\
	file://hciattach-opi-ttybt0.service \
"

# NOTE: Adding a systemd service in a BSP layer is probably not the right place to do.
# For now this works kinda like a hotfix, because /dev/ttyBT0 needs to be attached
# somewhere.
do_install:append() {
	if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -d ${D}${systemd_unitdir}/system
        install -m 644 ${WORKDIR}/hciattach-opi-ttybt0.service ${D}${systemd_unitdir}/system/
    fi
}
