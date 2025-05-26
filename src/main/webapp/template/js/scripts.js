// Toggle Dark Mode with persistence
const modeSwitch = document.querySelector('.mode-switch');

// Kiểm tra trạng thái dark mode đã lưu trong localStorage khi trang được tải
if (localStorage.getItem('dark-mode') === 'enabled') {
    document.body.classList.add('dark-mode');
}

// Gắn sự kiện click để bật/tắt dark mode và lưu trạng thái
modeSwitch.addEventListener('click', () => {
    document.body.classList.toggle('dark-mode');

    // Lưu trạng thái vào localStorage
    if (document.body.classList.contains('dark-mode')) {
        localStorage.setItem('dark-mode', 'enabled');
    } else {
        localStorage.setItem('dark-mode', 'disabled');
    }
});

// Sidebar functionality
const sidebar = document.getElementById('sidebar');
const sidebarOverlay = document.getElementById('sidebarOverlay');
const sidebarToggle = document.querySelector('.sidebar-toggle');
const sidebarClose = document.querySelector('.sidebar-close');

if (sidebarToggle) {
    sidebarToggle.addEventListener('click', () => {
        sidebar.classList.add('active');
        sidebarOverlay.classList.add('active');
        document.body.classList.add('sidebar-open');
    });
}

if (sidebarClose) {
    sidebarClose.addEventListener('click', () => {
        sidebar.classList.remove('active');
        sidebarOverlay.classList.remove('active');
        document.body.classList.remove('sidebar-open');
    });
}

if (sidebarOverlay) {
    sidebarOverlay.addEventListener('click', () => {
        sidebar.classList.remove('active');
        sidebarOverlay.classList.remove('active');
        document.body.classList.remove('sidebar-open');
    });
}

// Close sidebar when clicking on menu items (mobile)
document.querySelectorAll('.sidebar-item').forEach(item => {
    item.addEventListener('click', () => {
        if (window.innerWidth <= 768) {
            sidebar.classList.remove('active');
            sidebarOverlay.classList.remove('active');
            document.body.classList.remove('sidebar-open');
        }
    });
});


