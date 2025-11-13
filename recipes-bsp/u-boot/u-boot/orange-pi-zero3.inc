FILESEXTRAPATHS:append := "${THISDIR}/files/${MACHINE}/:"

python __anonymous() {
    if 'developer' not in d.getVar('MACHINEOVERRIDES').split(':'):
        d.appendVar('SRC_URI', ' file://0001-rel-orangepi_zero3_defconfig-disable-boot-delay.patch')
    else:
        d.appendVar('SRC_URI', ' file://0001-dev-orangepi_zero3_defconfig-enable-boot-delay.patch')
}
