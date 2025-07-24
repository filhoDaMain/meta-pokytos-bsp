FILESEXTRAPATHS:append := "${THISDIR}/files:${THISDIR}/${PN}:"

SUMMARY = "Linux kernel"
SECTION = "kernel"
LICENSE = "GPL-2.0-only"
HOMEPAGE = "https://kernel.org/"

LINUX_VERSION = "6.12.28"
COMPATIBLE_MACHINE = "qemuarm|rpi"


require recipes-kernel/linux/linux-yocto.inc
include ${PN}/include/${MACHINE}.inc


KBRANCH = "linux-6.12.y"
SRCREV_machine = "f08cdc6cc92e3d23a05745f0f12f8caa348a27b4"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

KMETA = "kernel-meta"
KMETABRANCH = "yocto-6.12"
SRCREV_meta = "f517f6553a2e35532b0c3d4fb53cba43781ac567"

# Kernel configuration (from yocto-kernel-cache)
LINUX_KERNEL_TYPE = "tiny"
KERNEL_EXTRA_FEATURES = "cfg/fs/ext4.scc features/cgroups/cgroups.scc"
KERNEL_FEATURES:append = " ${KERNEL_EXTRA_FEATURES}"

# Emulation (QEMU) specific
KERNEL_FEATURES:append:qemuall = " cfg/virtio.scc"

PV = "${LINUX_VERSION}+git${SRCPV}"
SRC_URI += "\
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=https;name=machine;branch=${KBRANCH} \
    git://git.yoctoproject.org/yocto-kernel-cache;protocol=https;type=kmeta;name=meta;branch=${KMETABRANCH};destsuffix=${KMETA} \
"

# Patch kernel config for kernel debugging support
# //TODO - might be wiser to move kernel conf fragments into machine specific directories!
SRC_URI:append = "${@bb.utils.contains('KERNEL_DEBUG', '1', 'file://debug.cfg', '', d)}"
