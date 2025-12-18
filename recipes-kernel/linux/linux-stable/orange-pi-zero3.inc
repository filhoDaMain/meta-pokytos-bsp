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
SRC_URI += "\
    file://add-nodes-for-sunxi-info-sunxi-addr-and-sunxi-dump-reg.patch \
    file://arm64-dts-allwinner-sun50i-h616-Add-VPU-node.patch \
    file://drv-nvmem-sunxi_sid-Support-SID-on-H616.patch \
    file://drv-rtc-sun6i-support-RTCs-without-external-LOSCs.patch \
    file://drv-rtc-sun6i-Add-Allwinner-H616-support.patch \
    file://drv-soc-sunxi-sram-Add-SRAM-C1-H616-handling.patch \
    file://drv-staging-media-sunxi-cedrus-add-H616-variant.patch \
    file://nvmem-sunxi_sid-add-sunxi_get_soc_chipid-sunxi_get_serial.patch \
    file://arm64-dts-h616-add-wifi-support-for-orange-pi-zero-2-and-zero3.patch \
"


# Current dtsi files lack a GPU node, so this patch which overrides gpu node won't compile:
# file://arm64-dts-sun50i-h618-orangepi-zero3-Enable-GPU-mali.patch
#
# TODO add the missing gpu node to the upstream dtsi file
#
