FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:kerneldebug = "file://debug.cfg"
