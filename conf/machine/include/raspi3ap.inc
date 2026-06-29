# Based on 'raspberrypi3.conf' from meta-raspberrypi
DEFAULTTUNE ?= "cortexa7thf-neon-vfpv4"
require conf/machine/include/arm/armv7a/tune-cortexa7.inc
include conf/machine/include/rpi-base.inc

# "Act" as a raspberrypi3 for all other recipes which don't have explicit
# support for raspi3ap machine
MACHINEOVERRIDES:prepend = "raspberrypi3:"

PREFERRED_PROVIDER_virtual/kernel = "linux-stable"
PREFERRED_PROVIDER_virtual/bootloader = "u-boot"

unset MACHINE_EXTRA_RRECOMMENDS
unset IMAGE_BOOT_FILES
unset KERNEL_DEVICETREE
