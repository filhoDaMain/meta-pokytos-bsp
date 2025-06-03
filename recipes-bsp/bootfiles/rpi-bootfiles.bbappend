do_deploy:append() {
    #cp ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/* ${DEPLOY_DIR_IMAGE}/
    cp ${S}/*.dtb ${DEPLOY_DIR_IMAGE}/
    cp ${S}/*.bin ${DEPLOY_DIR_IMAGE}/
    cp ${S}/overlays/* ${DEPLOY_DIR_IMAGE}/
}