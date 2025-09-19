SUMMARY = "7 Segment Display Driver"
DESCRIPTION = "${SUMMARY}"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

inherit module

BRANCH = "main"
SRCREV = "e6ef174142ad1fbb42c895711cb2f2e4fef47a35"

SRC_URI = "\
    git://github.com/filhoDaMain/display7.git;protocol=https;branch=${BRANCH} \
"

S = "${WORKDIR}/git"

RPROVIDES:${PN} += "kernel-module-display7"

# Enable auto-load for this out-of-tree module
KERNEL_MODULE_AUTOLOAD += "${PN}"
