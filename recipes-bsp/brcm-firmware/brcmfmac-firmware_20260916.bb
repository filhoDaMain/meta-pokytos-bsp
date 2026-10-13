SUMMARY = "Firmware blobs for brcmfmac from kernel.org"
HOMEPAGE = "https://git.kernel.org/pub/scm/linux/kernel/git/firmware/linux-firmware.git"
SECTION = "firmware"

LICENSE = "firmware-cypress & firmware-broadcom_bcm43xx"
LIC_FILES_CHKSUM = "\
    file://LICENSES/LICENCE.cypress;md5=48cd9436c763bf873961f9ed7b5c147b \
    file://LICENSES/LICENCE.broadcom_bcm43xx;md5=3160c14df7228891b868060e1951dfbc \
"

FILESEXTRAPATHS:append := "${THISDIR}/include:"
NO_GENERIC_LICENSE[firmware-cypress] = "LICENSES/LICENCE.cypress"
NO_GENERIC_LICENSE[firmware-broadcom_bcm43xx] = "LICENSES/LICENCE.broadcom_bcm43xx"

SRCREV = "ab23307cfe7f9366c819025ca3e4778299bc2db2"
SRC_URI = "\
    git://git.kernel.org/pub/scm/linux/kernel/git/firmware/linux-firmware;branch=main;protocol=https \    
"
S = "${WORKDIR}/git"

inherit allarch
do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    # Install Broadcom and Cypress Licenses. Blobs are installed in machine specific .inc files
    install -d ${D}${nonarch_base_libdir}/firmware/brcm ${D}${nonarch_base_libdir}/firmware/cypress
    cp LICENSES/LICENCE.cypress ${D}${nonarch_base_libdir}/firmware/LICENCE.cypress
    cp LICENSES/LICENCE.broadcom_bcm43xx ${D}${nonarch_base_libdir}/firmware/LICENCE.broadcom_bcm43xx
}

FILES:${PN} = "\
    ${nonarch_base_libdir}/firmware/brcm/ \
    ${nonarch_base_libdir}/firmware/cypress/ \
    ${nonarch_base_libdir}/firmware/LICENCE.broadcom_bcm43xx \
    ${nonarch_base_libdir}/firmware/LICENCE.cypress \
"

include include/${MACHINE}.inc
