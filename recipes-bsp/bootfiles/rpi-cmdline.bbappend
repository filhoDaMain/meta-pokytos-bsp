ENABLE_UART = "1"

do_deploy:prepend() {
    cp ${WORKDIR}/cmdline.txt ${DEPLOY_DIR_IMAGE}/
}