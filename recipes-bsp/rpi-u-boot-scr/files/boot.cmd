setenv bootargs "root=/dev/mmcblk0p2 8250.nr_uarts=1"
fatload mmc 0:1 ${kernel_addr_r} uImage
bootm ${kernel_addr_r} - ${fdt_addr}
