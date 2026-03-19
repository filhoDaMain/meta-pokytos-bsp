# Based on 'raspberrypi3.conf' from meta-raspberrypi but using different:
# * Kernel device tree (from upstream)
# * U-boot machine (from upstream)
#

DEFAULTTUNE ?= "cortexa7thf-neon-vfpv4"
require conf/machine/include/arm/armv7a/tune-cortexa7.inc
include conf/machine/include/rpi-base.inc


# "Act" as a raspberrypi3 for all other recipes which don't have explicit
# support for raspi3ap machine
MACHINEOVERRIDES:prepend = "raspberrypi3:"
SDIMG_KERNELIMAGE ?= "kernel7.img"
UBOOT_MACHINE = "rpi_3_32b_config"
SERIAL_CONSOLES ?= "115200;ttyS0"
ARMSTUB ?= "armstub7.bin"
RPI_USE_U_BOOT = "1"
ENABLE_UART = "1"

unset MACHINE_EXTRA_RRECOMMENDS
MACHINE_EXTRA_RRECOMMENDS = "\
    kernel-modules \
    brcm-firmware \
    kernel-module-display7 \
"

unset IMAGE_BOOT_FILES
IMAGE_BOOT_FILES = "\
    ${BOOTFILES_DIR_NAME}/* \
    bcm2837-rpi-3-a-plus.dtb \
    ${RPI_EXTRA_IMAGE_BOOT_FILES} \
"

unset KERNEL_DEVICETREE
KERNEL_DEVICETREE = "broadcom/bcm2837-rpi-3-a-plus.dtb"

PREFERRED_PROVIDER_virtual/kernel = "linux-stable"
PREFERRED_PROVIDER_virtual/bootloader = "u-boot"
