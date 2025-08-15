SUMMARY = "Linux kernel firmware files from Broadcom and Cypress"
DESCRIPTION = "Updated firmware files from upstream for RPI wi-fi and bluetooth modules"
HOMEPAGE = "https://git.kernel.org/pub/scm/linux/kernel/git/firmware/linux-firmware.git"
SECTION = "firmware"

LICENSE = "firmware-cypress & firmware-broadcom_bcm43xx"
LIC_FILES_CHKSUM = "\
    file://LICENCE.cypress;md5=48cd9436c763bf873961f9ed7b5c147b \
    file://LICENCE.broadcom_bcm43xx;md5=3160c14df7228891b868060e1951dfbc \
"

FILESEXTRAPATHS:append := "${THISDIR}/include:"

NO_GENERIC_LICENSE[firmware-cypress] = "LICENCE.cypress"
NO_GENERIC_LICENSE[firmware-broadcom_bcm43xx] = "LICENCE.broadcom_bcm43xx"

SRCREV = "910c190740916a9969ad5105137fb88ae4ce34c8"
SRC_URI = "\
    git://git.kernel.org/pub/scm/linux/kernel/git/firmware/linux-firmware;branch=main;protocol=https \    
"

S = "${WORKDIR}/git"

inherit allarch
do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware/brcm ${D}${nonarch_base_libdir}/firmware/cypress

    cp LICENCE.cypress ${D}${nonarch_base_libdir}/firmware/LICENCE.cypress
    cp LICENCE.broadcom_bcm43xx ${D}${nonarch_base_libdir}/firmware/LICENCE.broadcom_bcm43xx
    cp brcm/BCM-0bb4-0306.hcd ${D}${nonarch_base_libdir}/firmware/brcm/BCM-0bb4-0306.hcd

    # the rest of the files are dependent on the SoC and added by ${MACHINE}.inc
}

FILES:${PN} = "\
    ${nonarch_base_libdir}/firmware/brcm/ \
    ${nonarch_base_libdir}/firmware/cypress/ \
    ${nonarch_base_libdir}/firmware/LICENCE.broadcom_bcm43xx \
    ${nonarch_base_libdir}/firmware/LICENCE.cypress \
    ${nonarch_base_libdir}/firmware/brcm/BCM-0bb4-0306.hcd \
"

include include/${MACHINE}.inc
