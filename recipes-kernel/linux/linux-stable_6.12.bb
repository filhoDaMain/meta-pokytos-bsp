FILESEXTRAPATHS:append := "${THISDIR}/files:"

SUMMARY = "Linux kernel"
SECTION = "kernel"
LICENSE = "GPL-2.0-only"
HOMEPAGE = "https://kernel.org/"

require recipes-kernel/linux/linux-yocto.inc
require recipes-kernel/linux/linux-raspberrypi.inc

LINUX_VERSION = "6.12.28"
PV = "${LINUX_VERSION}+git${SRCPV}"
COMPATIBLE_MACHINE = "qemuarm|raspberrypi3"

KBRANCH = "linux-6.12.y"
SRCREV_machine = "f08cdc6cc92e3d23a05745f0f12f8caa348a27b4"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

SRCREV_rpilinux = "ce20a8fdbf5891ae7e85f9b8c50231530113f4d5"

KMETA = "kernel-meta"
KMETABRANCH = "yocto-6.12"
SRCREV_meta = "f517f6553a2e35532b0c3d4fb53cba43781ac567"

# Kernel configuration (from yocto-kernel-cache)
LINUX_KERNEL_TYPE = "tiny"
KERNEL_EXTRA_FEATURES = "cfg/fs/ext4.scc features/cgroups/cgroups.scc"
KERNEL_FEATURES:append = " ${KERNEL_EXTRA_FEATURES}"

# Emulation (QEMU) specific
KERNEL_FEATURES:append:qemuall = " cfg/virtio.scc"

KERNEL_DEVICETREE:raspberrypi3 = "broadcom/bcm2837-rpi-3-a-plus.dtb"
KERNEL_EXTRA_ARGS:raspberrypi3 += "LOADADDR=${UBOOT_ENTRYPOINT}"

UBOOT_ENTRYPOINT:raspberrypi3 =       "0x00008000"
UBOOT_LOADADDRESS:raspberrypi3 =      "0x00008000"

RPI_USE_U_BOOT= "1"

DEPENDS += "rpi-bootfiles"

# SRC_URI = "\
#     git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=https;name=machine;branch=${KBRANCH} \
#     git://git.yoctoproject.org/yocto-kernel-cache;protocol=https;type=kmeta;name=meta;branch=${KMETABRANCH};destsuffix=${KMETA} \
#     git://github.com/raspberrypi/linux.git;protocol=https;name=rpilinux;branch=rpi-6.12.y;destsuffix=rpilinux \
#     file://bcm2709_defconfig \
# "

SRC_URI = "\
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=https;name=machine;branch=${KBRANCH} \
    git://git.yoctoproject.org/yocto-kernel-cache;protocol=https;type=kmeta;name=meta;branch=${KMETABRANCH};destsuffix=${KMETA} \
    git://github.com/raspberrypi/linux.git;protocol=https;name=rpilinux;branch=rpi-6.12.y;destsuffix=rpilinux \
"

# do_unpack:append() {
#     cp ${WORKDIR}/rpilinux/arch/arm/configs/bcm2709_defconfig ${WORKDIR}/
# }

do_kernel_metadata:prepend(){
    cp ${WORKDIR}/rpilinux/arch/arm/configs/* ${S}/arch/arm/configs/
}