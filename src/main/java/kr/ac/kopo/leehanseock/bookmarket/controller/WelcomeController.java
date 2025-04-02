package kr.ac.kopo.leehanseock.bookmarket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //텍스트, JSON, HTML 파일을 리턴할 때 쓰는 컨트롤러
public class WelcomeController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String welcomeMethod() {
        String welcomeHTML = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>No24</title>\n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n" +
                "          integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<div class=\"dropdown position-fixed bottom-0 end-0 mb-3 me-3 bd-mode-toggle\">\n" +
                "    <button class=\"btn btn-bd-primary py-2 dropdown-toggle d-flex align-items-center\"\n" +
                "            id=\"bd-theme\"\n" +
                "            type=\"button\"\n" +
                "            aria-expanded=\"false\"\n" +
                "            data-bs-toggle=\"dropdown\"\n" +
                "            aria-label=\"Toggle theme (auto)\">\n" +
                "        <svg class=\"bi my-1 theme-icon-active\" width=\"1em\" height=\"1em\"><use href=\"#circle-half\"></use></svg>\n" +
                "        <span class=\"visually-hidden\" id=\"bd-theme-text\">Toggle theme</span>\n" +
                "    </button>\n" +
                "    <ul class=\"dropdown-menu dropdown-menu-end shadow\" aria-labelledby=\"bd-theme-text\">\n" +
                "        <li>\n" +
                "            <button type=\"button\" class=\"dropdown-item d-flex align-items-center\" data-bs-theme-value=\"light\" aria-pressed=\"false\">\n" +
                "                <svg class=\"bi me-2 opacity-50\" width=\"1em\" height=\"1em\"><use href=\"#sun-fill\"></use></svg>\n" +
                "                Light\n" +
                "                <svg class=\"bi ms-auto d-none\" width=\"1em\" height=\"1em\"><use href=\"#check2\"></use></svg>\n" +
                "            </button>\n" +
                "        </li>\n" +
                "        <li>\n" +
                "            <button type=\"button\" class=\"dropdown-item d-flex align-items-center\" data-bs-theme-value=\"dark\" aria-pressed=\"false\">\n" +
                "                <svg class=\"bi me-2 opacity-50\" width=\"1em\" height=\"1em\"><use href=\"#moon-stars-fill\"></use></svg>\n" +
                "                Dark\n" +
                "                <svg class=\"bi ms-auto d-none\" width=\"1em\" height=\"1em\"><use href=\"#check2\"></use></svg>\n" +
                "            </button>\n" +
                "        </li>\n" +
                "        <li>\n" +
                "            <button type=\"button\" class=\"dropdown-item d-flex align-items-center active\" data-bs-theme-value=\"auto\" aria-pressed=\"true\">\n" +
                "                <svg class=\"bi me-2 opacity-50\" width=\"1em\" height=\"1em\"><use href=\"#circle-half\"></use></svg>\n" +
                "                Auto\n" +
                "                <svg class=\"bi ms-auto d-none\" width=\"1em\" height=\"1em\"><use href=\"#check2\"></use></svg>\n" +
                "            </button>\n" +
                "        </li>\n" +
                "    </ul>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "<main>\n" +
                "    <div class=\"container py-4\">\n" +
                "        <header class=\"pb-3 mb-4 border-bottom\">\n" +
                "            <a href=\"/\" class=\"d-flex align-items-center text-body-emphasis text-decoration-none\">\n" +
                "                <svg version=\"1.0\" id=\"Layer_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"\n" +
                "                     width=\"32px\" height=\"32px\" viewBox=\"0 0 64 64\" enable-background=\"new 0 0 64 64\" xml:space=\"preserve\">\n" +
                "<g>\n" +
                "\t<path fill=\"#394240\" d=\"M56,0H8C5.789,0,4,1.789,4,4v52c0,4.418,3.582,8,8,8h44c2.211,0,4-1.789,4-4V4C60,1.789,58.211,0,56,0z\n" +
                "\t\t M52,56H16c-2.211,0-4-1.789-4-4s1.789-4,4-4h36V56z M52,40H12V8h40V40z\"/>\n" +
                "    <path fill=\"#F9EBB2\" d=\"M52,56H16c-2.211,0-4-1.789-4-4s1.789-4,4-4h36V56z\"/>\n" +
                "    <rect x=\"12\" y=\"8\" fill=\"#45AAB8\" width=\"40\" height=\"32\"/>\n" +
                "</g>\n" +
                "</svg>\n" +
                "                <span class=\"fs-4\">&nbsp;NO24</span>\n" +
                "            </a>\n" +
                "        </header>\n" +
                "\n" +
                "        <div class=\"p-5 mb-4 bg-body-tertiary rounded-3\">\n" +
                "            <div class=\"container-fluid py-5\">\n" +
                "                <h1 class=\"display-5 fw-bold\">NO24에 오신것을 환영합니다</h1>\n" +
                "                <p class=\"col-md-8 fs-4\">고객의 요구에 \"NO!\"라고 답할 수 있는 배짱을 가진 쇼핑몰</p>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class=\"row align-items-md-stretch text-center\">\n" +
                "            <div class=\"col-md-12\">\n" +
                "                <div class=\"h-100 p-5 rounded-3\">\n" +
                "                    <h2>Welcome to NO24</h2>\n" +
                "                    <p>The only shopping mall that can say \"No!\" to customers</p>\n" +
                "                </div>\n" +
                "        </div>\n" +
                "\n" +
                "        <footer class=\"pt-3 mt-4 text-body-secondary border-top\">\n" +
                "            <span class=\"text-body-secondary\">&copy; 2025 NO24</span>\n" +
                "        </footer>\n" +
                "    </div>\n" +
                "</main>\n" +
                "</body>\n" +
                "</html>";
        return welcomeHTML;
    }
}
