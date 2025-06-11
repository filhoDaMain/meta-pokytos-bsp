do_deploy:prepend(){
    mkdir -p ${DEPLOY_DIR_IMAGE}
    cp ${WORKDIR}/cmdline.txt ${DEPLOY_DIR_IMAGE}/
}