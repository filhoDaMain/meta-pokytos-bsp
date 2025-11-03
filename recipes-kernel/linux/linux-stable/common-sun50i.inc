FILESEXTRAPATHS:append := "${THISDIR}/files/sun50i/:"


require recipes-kernel/linux/linux-yocto.inc
unset LINUX_VERSION_EXTENSION
unset LIC_FILES_CHKSUM

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

SRC_URI += "\
   file://${CUSTOM_KERNEL_CONFIG} \
"

# Copy the compiled DTB to where u-boot expects it to be.
# It's a bit of a hack but I currently don't know how to change the assigned value of ftdtfile
# which is set to 'allwinner/<...>.dtb' by the u-boot SPL binary.
KERNEL_DTB_WITHOUT_PREFIX = "${@d.getVar('KERNEL_DEVICETREE', '').split('/')[-1]}"
do_after_deploy() {
   cd ${DEPLOY_DIR_IMAGE}
   rm -rf allwinner && mkdir allwinner
   cp ${KERNEL_DTB_WITHOUT_PREFIX} allwinner/${KERNEL_DTB_WITHOUT_PREFIX}
}

addtask after_deploy after do_deploy before do_build

FILES:${PN} += "${DEPLOY_DIR_IMAGE}/allwinner"
