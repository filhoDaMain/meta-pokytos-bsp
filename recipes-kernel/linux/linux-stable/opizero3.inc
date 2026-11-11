require common-sun50i.inc

SRC_URI:append:developer = " \
    file://debug.cfg \
"

# Conditionally included drivers.
# NOTE: These enable the generic support for bluetooth and wifi.
# The specific SoC drivers are provided by uwe5622 recipe's packages.
SRC_URI += "\
    ${@bb.utils.contains("MACHINE_FEATURES", "bluetooth", "\
        file://bluetooth.cfg \
    ", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "\
        file://wifi.cfg \
    ", "", d)} \
"

# Patch missing support in upstream kernel
SRC_URI += "\
    file://armbian-patches/v6.12/drv-pinctrl-pinctrl-sun50i-a64-disable_strict_mode.patch \
    file://armbian-patches/v6.12/drv-rtc-sun6i-support-RTCs-without-external-LOSCs.patch \
    file://armbian-patches/v6.12/drv-staging-media-sunxi-cedrus-add-H616-variant.patch \
    file://armbian-patches/v6.12/drv-soc-sunxi-sram-Add-SRAM-C1-H616-handling.patch \
    file://armbian-patches/v6.12/drv-pinctrl-sunxi-pinctrl-sun50i-h6.c-GPIO-disable_strict_mode.patch \
    file://armbian-patches/v6.12/drv-rtc-sun6i-Add-Allwinner-H616-support.patch \
    file://armbian-patches/v6.12/drv-nvmem-sunxi_sid-Support-SID-on-H616.patch \
    file://armbian-patches/v6.12/Add-ws2812-RGB-driver-for-allwinner-H616.patch \
    file://armbian-patches/v6.12/nvmem-sunxi_sid-add-sunxi_get_soc_chipid-sunxi_get_serial.patch \
    file://armbian-patches/v6.12/drivers-pwm-Add-pwm-sunxi-enhance-driver-for-h616.patch \
    file://armbian-patches/v6.12/add-nodes-for-sunxi-info-sunxi-addr-and-sunxi-dump-reg.patch \
    file://armbian-patches/v6.12/arm64-dts-sun50i-h6-Add-r_uart-uart2-3-pins.patch \
    file://armbian-patches/v6.12/arm64-dts-sun50i-h616.dtsi-reserved-memory-512K-for-BL31.patch \
    file://armbian-patches/v6.12/arm64-dts-sun50i-h616-orangepi-zero2-reg_usb1_vbus-status-ok.patch \
    file://armbian-patches/v6.12/arm64-dts-allwinner-sun50i-h616-Add-VPU-node.patch \
    file://armbian-patches/v6.12/arm64-dts-sun50i-h616-x96-mate-T95-eth-sd-card-hack.patch \
    file://armbian-patches/v6.12/arm64-dts-add-sun50i-h618-cpu-dvfs.dtsi.patch \
    file://armbian-patches/v6.12/arm64-dts-sun50i-h618-orangepi-zero2w-Add-missing-nodes.patch \
    file://armbian-patches/v6.12/arm64-dts-allwinner-h616-orangepi-zero2-Enable-expansion-board-.patch \
    file://armbian-patches/v6.12/arm64-dts-sun50i-h6.dtsi-improve-thermals.patch \
    file://armbian-patches/v6.12/arm64-dts-h616-add-wifi-support-for-orange-pi-zero-2-and-zero3.patch \
    file://armbian-patches/v6.12/arm64-sun50i-h616-Add-i2c-2-3-4-uart-2-5-pins.patch \
    file://armbian-patches/v6.12/arm64-dts-sun50i-h616-Add-i2c3-pa-pwm-pins.patch \
"
