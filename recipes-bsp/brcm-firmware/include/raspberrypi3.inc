do_install:append(){
    cp cypress/cyfmac43455-sdio.bin ${D}${nonarch_base_libdir}/firmware/cypress/cyfmac43455-sdio.bin
    cp cypress/cyfmac43455-sdio.clm_blob ${D}${nonarch_base_libdir}/firmware/cypress/cyfmac43455-sdio.clm_blob
    cp brcm/brcmfmac43455-sdio.raspberrypi,3-model-b-plus.txt ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.raspberrypi,3-model-b-plus.txt

    ln --relative --symbolic ${D}${nonarch_base_libdir}/firmware/cypress/cyfmac43455-sdio.bin ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.raspberrypi,3-model-a-plus.bin
    ln --relative --symbolic ${D}${nonarch_base_libdir}/firmware/cypress/cyfmac43455-sdio.clm_blob ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.raspberrypi,3-model-a-plus.clm_blob
    ln --relative --symbolic ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.raspberrypi,3-model-b-plus.txt ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.raspberrypi,3-model-a-plus.txt
}

FILES:${PN} += "\
    ${nonarch_base_libdir}/firmware/cypress/cyfmac43455-sdio.bin \
    ${nonarch_base_libdir}/firmware/cypress/cyfmac43455-sdio.clm_blob \
    ${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.raspberrypi,3-model-b-plus.txt \
    ${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.raspberrypi,3-model-a-plus.bin \
    ${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.raspberrypi,3-model-a-plus.clm_blob \
    ${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.raspberrypi,3-model-a-plus.txt \
"