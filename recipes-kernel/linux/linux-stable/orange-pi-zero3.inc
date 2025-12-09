require common-sun50i.inc

SRC_URI:append:developer = "\
    file://debug.cfg \
"

SRC_URI += "\
    file://sunxi-kmeta;type=kmeta;name=sunxi-kmeta;destsuffix=sunxi-kmeta \
"

KERNEL_FEATURES:append = "\
    bsp/uwe5622/uwe5622-6_6.scc \
"

# TODO
# Add patches from
# https://github.com/armbian/build/tree/main/patch/kernel/archive/sunxi-6.12/patches.armbian
# to enable WiFi
