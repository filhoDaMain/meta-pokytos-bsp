FILESEXTRAPATHS:append := "${THISDIR}/files/${MACHINE}/:"

python __anonymous() {
    if 'developer' not in d.getVar('MACHINEOVERRIDES').split(':'):
        d.appendVar('SRC_URI', ' file://0001-rpi_3_32b_defconfig-disable-boot-delay.patch')
}
