require common-rpi.inc

# Enable multi-core
SRC_URI += "\
    file://smp.cfg \
"

SRC_URI:append:developer = "\
    file://debug.cfg \
"
