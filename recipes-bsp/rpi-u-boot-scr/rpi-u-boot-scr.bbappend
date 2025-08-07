FILESEXTRAPATHS:append := "${THISDIR}/files:"

# substitute boot.cmd.in file
unset SRC_URI

SRC_URI = "file://boot.cmd"

do_compile() {
    mkimage -A ${UBOOT_ARCH} -T script -C none -n "Boot script" -d "${WORKDIR}/boot.cmd" boot.scr
}