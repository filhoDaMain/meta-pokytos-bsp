FILESEXTRAPATHS:append := "${THISDIR}/files/rpi/:${BSP_LAYER_RPI}/recipes-kernel/linux/files/:"


# Common Build and boot definitions for all raspberries
require recipes-kernel/linux/linux-raspberrypi.inc

SRC_URI += "\
    file://${CUSTOM_KERNEL_CONFIG} \
"
