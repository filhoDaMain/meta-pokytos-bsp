SUMMARY = "Packagegroup which provides firmware blobs for raspi3ap machine"
SECTION = "firmware"
COMPATIBLE_MACHINE = "raspi3ap"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup


# Bundle
PROVIDES = "${PACKAGES}"
PACKAGES += "\
    raspi3ap-firmware-wifi \
    raspi3ap-firmware-bluetooth \
"
RDEPENDS:packagegroup-raspi3ap-firmware = "\
    raspi3ap-firmware-wifi \
    raspi3ap-firmware-bluetooth \
"


# Sub packages
SUMMARY:raspi3ap-firmware-wifi = "Firmware files from Cypress for brcmfmac"
RDEPENDS:raspi3ap-firmware-wifi = "\
    brcmfmac-firmware \
"

SUMMARY:raspi3ap-firmware-bluetooth = "Firmware files for BCM4345C0 chip"
RDEPENDS:raspi3ap-firmware-bluetooth = "\
    bluez-firmware-rpidistro-bcm4345c0-hcd \
"
