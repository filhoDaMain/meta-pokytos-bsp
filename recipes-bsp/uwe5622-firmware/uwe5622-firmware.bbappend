# Fix expected path, so the following message does not pollute the boot logs
# "WCN_ERR: load_firmware_data_path: open file /lib/firmware/uwe5622/wcnmodem.bin"
do_install:append(){
    install -d ${D}${nonarch_base_libdir}/firmware/uwe5622
    ln --relative --symbolic ${D}${nonarch_base_libdir}/firmware/wcnmodem.bin ${D}${nonarch_base_libdir}/firmware/uwe5622/wcnmodem.bin
}
