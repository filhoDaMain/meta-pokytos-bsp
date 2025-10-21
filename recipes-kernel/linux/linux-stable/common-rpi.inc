FILESEXTRAPATHS:append := "${THISDIR}/files/rpi/:${TOPDIR}/../meta-raspberrypi/recipes-kernel/linux/files/:"


# Common Build and boot definitions for all raspberries
require recipes-kernel/linux/linux-raspberrypi.inc

SRC_URI += "\
    file://${CUSTOM_KERNEL_CONFIG} \
"
