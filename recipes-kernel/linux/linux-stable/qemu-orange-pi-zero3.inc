require common-sun50i.inc

SRC_URI:append = "\
    file://virtio.cfg \
"

# SRC_URI:append:developer = "\
#     file://debug.cfg \
# "

# SRC_URI += "\
#     file://sunxi-kmeta;type=kmeta;name=sunxi-kmeta;destsuffix=sunxi-kmeta \
# "

# KERNEL_FEATURES:append = "\
#     bsp/uwe5622/uwe5622-6_12.scc \
# "


# SRC_URI += "\
#     file://armbian-uwe5622/add-nodes-for-sunxi-info-sunxi-addr-and-sunxi-dump-reg.patch \
#     file://armbian-uwe5622/arm64-dts-allwinner-sun50i-h616-Add-VPU-node.patch \
#     file://armbian-uwe5622/drv-nvmem-sunxi_sid-Support-SID-on-H616.patch \
#     file://armbian-uwe5622/drv-rtc-sun6i-support-RTCs-without-external-LOSCs.patch \
#     file://armbian-uwe5622/drv-rtc-sun6i-Add-Allwinner-H616-support.patch \
#     file://armbian-uwe5622/drv-soc-sunxi-sram-Add-SRAM-C1-H616-handling.patch \
#     file://armbian-uwe5622/drv-staging-media-sunxi-cedrus-add-H616-variant.patch \
#     file://armbian-uwe5622/nvmem-sunxi_sid-add-sunxi_get_soc_chipid-sunxi_get_serial.patch \
#     file://armbian-uwe5622/arm64-dts-h616-add-wifi-support-for-orange-pi-zero-2-and-zero3.patch \
# "



# Current dtsi files lack a GPU node, so this patch which overrides gpu node won't compile:
# arm64-dts-sun50i-h618-orangepi-zero3-Enable-GPU-mali.patch
#
# TODO add the missing gpu node to the upstream dtsi file
#
