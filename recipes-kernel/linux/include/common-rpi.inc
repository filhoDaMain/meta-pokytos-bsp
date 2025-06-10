require recipes-kernel/linux/linux-raspberrypi.inc
require recipes-bsp/common/raspberrypi-firmware.inc
DEPENDS += "rpi-bootfiles u-boot rpi-u-boot-scr rpi-cmdline rpi-config"


RPI_USE_U_BOOT= "1"

SRCREV_rpilinux = "ce20a8fdbf5891ae7e85f9b8c50231530113f4d5"

SRC_URI = "\
    git://github.com/raspberrypi/linux.git;protocol=https;name=rpilinux;branch=rpi-6.12.y;destsuffix=rpilinux \
    ${RPIFW_SRC_URI} \
"

RPI_KERNEL_DEVICETREE_OVERLAYS:remove = "overlays/imx708.dtbo"

RPI_KERNEL_DEVICETREE:remove = "bcm2711-rpi-cm4s.dtb"

do_compile[depends] += "u-boot:do_install rpi-u-boot-scr:do_install rpi-cmdline:do_install rpi-config:do_install"
do_deploy[depends] += "u-boot:do_deploy rpi-u-boot-scr:do_deploy rpi-cmdline:do_deploy rpi-config:do_deploy"

# Copy from rpilinux the kernel config files which are missing in linux-stable upstream sources
do_kernel_metadata:prepend(){
    cp ${WORKDIR}/rpilinux/arch/arm/configs/* ${S}/arch/arm/configs/
}

# Copy to Source Dir the pre-compiled files from raspberrypi-firmware.inc to bypass 
# the missing sources from upstream linux-stable kernel
do_compile:prepend(){
    cp ${RPIFW_S}/boot/*.dtb ${S}/arch/arm/boot/dts/
    touch ${S}/arch/arm/boot/dts/bcm2711-rpi-cm4s.dtb

    install -d ${S}/arch/arm/boot/dts/overlays
    cp ${RPIFW_S}/boot/overlays/* ${S}/arch/arm/boot/dts/overlays/
    touch ${S}/arch/arm/boot/dts/overlays/imx708.dtbo
}
 
# Copy to Build Dir
do_install:prepend(){
    install -d ${B}/arch/arm/boot/overlays
    cp -r ${RPIFW_S}/boot/* ${B}/arch/arm/boot/
}

# Create the missing files for wic install function to be happy
do_deploy:prepend(){
    mkdir -p ${DEPLOY_DIR_IMAGE}
    touch ${DEPLOY_DIR_IMAGE}/bcm2711-rpi-cm4s.dtb
    touch ${DEPLOY_DIR_IMAGE}/imx708.dtbo
}
