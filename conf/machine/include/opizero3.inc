# Based on 'orange-pi-zero2.conf' from meta-sunxi
require conf/machine/include/sun50i-h616.inc

# "Act" as an orange-pi-zero2 for all other recipes which don't have explicit
# support for orange-pi-zero3
MACHINEOVERRIDES:prepend = "orange-pi-zero2:"

PREFERRED_PROVIDER_virtual/kernel = "linux-stable"
PREFERRED_PROVIDER_virtual/bootloader = "u-boot"

unset MACHINE_EXTRA_RRECOMMENDS
unset IMAGE_BOOT_FILES
unset KERNEL_DEVICETREE
