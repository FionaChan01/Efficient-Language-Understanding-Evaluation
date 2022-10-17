import html2Canvas from 'html2canvas'
import JsPDF from 'jspdf'
export default {
    install(Vue, options) {
        Vue.prototype.getPdf = function () {
            var title = this.htmlTitle
            html2Canvas(document.querySelector('#pdfDom'), {
                allowTaint: false,
                useCORS: true,  //解决图片跨域问题
                scale: 2,
            }).then(function (canvas) {
                //document.body.appendChild(canvas);
                let contentWidth = canvas.width-200
                let contentHeight = canvas.height
                let pageData = canvas.toDataURL('image/jpeg', 1.0)
                var pdfX = (contentWidth + 10) / 2 * 0.75
                var pdfY = (contentHeight + 500) / 2 * 0.75 // 500为底部留白
                var imgX = pdfX;
                var imgY = (contentHeight / 2 * 0.75); //内容图片这里不需要留白的距离
                var img = new Image()
                img.src = pageData;
                img.onload = function () {
                    var PDF = new JsPDF('', 'pt', [pdfX, pdfY])
                    PDF.addImage(pageData, 'jpeg', 0, -40, imgX, imgY)
                    PDF.save(title + '.pdf')
                }

            })
        }
    }

}
