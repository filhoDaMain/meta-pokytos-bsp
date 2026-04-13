FILESEXTRAPATHS:append := "${THISDIR}/files/${MACHINE}/:"

SRC_URI:append = "file://custom.boot.cmd"

do_compile:append() {
    sed -i 's/dtb_marker/${KERNEL_DTB_FILE}/g' "${WORKDIR}/custom.boot.cmd"
    ${B}/tools/mkimage -C none -A arm -T script -d ${WORKDIR}/custom.boot.cmd ${WORKDIR}/custom.boot.scr
}

do_deploy:append() {
    install -m 0644 ${WORKDIR}/custom.boot.scr ${DEPLOYDIR}/boot.scr
}
