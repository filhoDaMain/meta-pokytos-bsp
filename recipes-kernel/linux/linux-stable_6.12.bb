SUMMARY = "Linux Kernel - Upstream stable tree"
SECTION = "kernel"
LICENSE = "GPL-2.0-only"
HOMEPAGE = "https://kernel.org/"


FILESEXTRAPATHS:append := "${THISDIR}/${PN}:"

# Local defconfig to use. Fetched in machine specific .inc file.
CUSTOM_KERNEL_CONFIG = "defconfig"
LINUX_VERSION = "6.12.28"
SRCREV_machine = "f08cdc6cc92e3d23a05745f0f12f8caa348a27b4"
KBRANCH = "linux-6.12.y"
KMETA = "kernel-meta"
KMETABRANCH = "yocto-6.12"
SRCREV_meta = "f517f6553a2e35532b0c3d4fb53cba43781ac567"
SRCREV_FORMAT = "machine_meta"

SRC_URI += "\
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=https;name=machine;branch=${KBRANCH} \
    git://git.yoctoproject.org/yocto-kernel-cache;protocol=https;type=kmeta;name=meta;branch=${KMETABRANCH};destsuffix=${KMETA} \
"

# Machine specific configurations
include ${PN}/include/${MACHINE}.inc

# Unset any possible assignement to KBUILD_DEFCONFIG from another layer,
# to be sure we use our CUSTOM_KERNEL_CONFIG configuration
unset KBUILD_DEFCONFIG

# Overwrite whatever machine specific files did to PV
PV = "${LINUX_VERSION}"
