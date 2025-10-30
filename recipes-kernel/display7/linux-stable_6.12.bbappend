# This bbappend handles device tree patching for display7 nodes

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
include linux-stable/${MACHINE}.inc
