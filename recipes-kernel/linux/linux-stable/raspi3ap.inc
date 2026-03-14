require common-rpi.inc

# Set upstream's Device Tree
# unset KERNEL_DEVICETREE
# KERNEL_DEVICETREE = "broadcom/bcm2837-rpi-3-a-plus.dtb"

# Enable multi-core
SRC_URI += "\
    file://smp.cfg \
"

SRC_URI:append:developer = "\
    file://debug.cfg \
"
