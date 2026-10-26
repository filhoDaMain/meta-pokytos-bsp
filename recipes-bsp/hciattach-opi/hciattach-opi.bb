SUMMARY = "hciattach-opi tool for Orange Pi"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

BRANCH = "next"
SRCREV = "206214916c796df6842a5df1d95ae580881ce603"

SRC_URI = "git://github.com/orangepi-xunlong/orangepi-build.git;protocol=https;branch=${BRANCH}"
S = "${WORKDIR}/git/external/cache/sources/hcitools"

# Local patches
SRC_URI += "\
    file://0001-Makefile-Fix-compiler-flags.patch \
    file://0002-hciattach-Fix-compiler-warnings.patch \
	file://opi-bluetooth-hciattach.service \
"

# Make specific target
do_compile() {
    oe_runmake hciattach_opi
}

do_install() {
	install -d ${D}${bindir}

	# Relative to ${B}
	install -m 0755 output/hciattach_opi ${D}${bindir}/hciattach_opi
}


# ---------------------------------------//------------------------------------------
inherit systemd
SYSTEMD_SERVICE:${PN} = "opi-bluetooth-hciattach.service"

# NOTE: Adding a systemd service in a BSP layer is probably not the right place to do.
# For now this works kinda like a hotfix, because /dev/ttyBT0 needs to be attached
# somehow and I dind't put much thought where to do this.
# Also, bluetooth should be a feature easily enabled/disabled in the future (re-work).
do_install:append() {
	if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -d ${D}${systemd_unitdir}/system
        install -m 644 ${WORKDIR}/opi-bluetooth-hciattach.service ${D}${systemd_unitdir}/system
    fi
}
# ---------------------------------------//------------------------------------------


FILES:${PN} += "\
	${bindir}/hciattach_opi \
"
