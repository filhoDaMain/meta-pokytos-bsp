SUMMARY = "Linux Kernel - Upstream stable tree"
SECTION = "kernel"
LICENSE = "GPL-2.0-only"
HOMEPAGE = "https://kernel.org/"


FILESEXTRAPATHS:append := "${THISDIR}/${PN}:"

# Local defconfig to use. Fetched in machine specific .inc file.
CUSTOM_KERNEL_CONFIG = "defconfig"
LINUX_VERSION = "6.12.112"
SRCREV_machine = "7aba70ab2e8d8ab3cd45abcaa15e1119a00dc42a"
KBRANCH = "linux-6.12.y"
KMETA = "kernel-meta"
KMETABRANCH = "yocto-6.12"
SRCREV_meta = "dc2f730835594adb136c5a7ec2dfe07b14432ccd"
SRCREV_FORMAT = "machine_meta"

SRC_URI += "\
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=https;name=machine;branch=${KBRANCH} \
    git://git.yoctoproject.org/yocto-kernel-cache;protocol=https;type=kmeta;name=meta;branch=${KMETABRANCH};destsuffix=${KMETA} \
"

# Machine specific configurations
include ${PN}/${MACHINE}.inc

# Unset any possible assignement to KBUILD_DEFCONFIG from another layer,
# to be sure we use our CUSTOM_KERNEL_CONFIG configuration
unset KBUILD_DEFCONFIG

# Overwrite whatever machine specific files did to PV
PV = "${LINUX_VERSION}"
