FILESEXTRAPATHS:append := "${THISDIR}:${THISDIR}/files/sun50i/:"

require recipes-kernel/linux/linux-yocto.inc
unset LINUX_VERSION_EXTENSION
unset LIC_FILES_CHKSUM

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

SRC_URI += "\
   file://${CUSTOM_KERNEL_CONFIG} \
"
