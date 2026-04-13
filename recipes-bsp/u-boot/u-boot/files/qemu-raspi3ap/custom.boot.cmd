setenv bootargs root=/dev/vda2 console=ttyAMA0
setenv loadaddr 0x40200000
fatload virtio 0:1 ${loadaddr} zImage
setenv loadaddr_dtb 0x49000000
fatload virtio 0:1 ${loadaddr_dtb} dtb_marker
bootz ${loadaddr} - ${loadaddr_dtb}
