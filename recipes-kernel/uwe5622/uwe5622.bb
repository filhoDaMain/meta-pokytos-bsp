SUMMARY = "Unisoc UWE5622 (sc2355) chip Wi-Fi driver"
DESCRIPTION = "UWE5622 Wi-Fi kernel driver also compatible with AW859A chip"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://unisocwifi/main.c;beginline=8;endline=15;md5=aeb8d44b736cf8f452a6aed43e45bddf"

FILESEXTRAPATHS:append := "${TOPDIR}/../meta-sunxi/recipes-kernel/linux/linux-mainline/sunxi-kmeta/bsp/uwe5622/"

inherit module

BRANCH = "orange-pi-6.1-sun50iw9"
SRCREV = "71144529b0334d1488624c41d0d3ba0cb03dd4c1"
DRIVER = "drivers/net/wireless/uwe5622"

SRC_URI = "\
    git://github.com/orangepi-xunlong/linux-orangepi.git;protocol=https;branch=${BRANCH}; \
"

SRC_URI += "\
    file://uwe5622-allwinner-v6.3-compilation-fix.patch;patchdir=${WORKDIR}/git \
    file://0002-drivers-uwe5622-Makefile-compatible-with-out-of-tree.patch;patchdir=${WORKDIR}/git \
    file://0001-drivers-uwe5622-fix-compilation-on-6.12-kernels.patch;patchdir=${WORKDIR}/git \
"

S = "${WORKDIR}/git/${DRIVER}"

RPROVIDES:${PN} += "kernel-module-uwe5622"
